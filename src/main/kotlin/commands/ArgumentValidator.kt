package commands

import commands.branch.BranchType
import commands.upload.CommitType
import java.io.File
import kotlin.system.exitProcess

class ArgumentValidator {
    private val command: FennecCommand
    private val arguments: List<String>

    constructor(command: FennecCommand, arguments: List<String>) {
        this.command = command
        this.arguments = arguments
    }

    private fun validateType(type:ArgumentType, argument: String): Boolean {
        return when(type) {
            ArgumentType.DIRECTORY -> {
                val file = File(argument)
                file.exists() && file.isDirectory
            }
            ArgumentType.NUMBER -> {
                argument.toIntOrNull() != null
            }
            ArgumentType.ENUM_COMMITTYPE -> {
                CommitType.values().map { it.name }.contains(argument.uppercase())
            }
            ArgumentType.ENUM_BRANCHTYPE -> {
                BranchType.values().map { it.name }.contains(argument.uppercase())
            }
            ArgumentType.STRING -> true
        }
    }

    public fun validate() {
        if(arguments.size > command.getRequiredArguments().size) {
            System.err.println("Expected ${command.getRequiredArguments().size} arguments but got ${arguments.size}")
            CommandHelper.printCommandHelp(command)
            exitProcess(1)
        }

        for(i in command.getRequiredArguments().indices) {
            val required = command.getRequiredArguments().get(i)
            if(arguments.size <= i && !required.optional) {
                val requiredType = required.allowType.map { it.name }.joinToString("/")
                System.err.println("Command '${command.getName()}' requires an argument '${required.name}'(${requiredType} required)")
                exitProcess(1)
            }

            if(required.optional) continue

            val argument = arguments.get(i)

            val isValidArgument = required.allowType.map {
                validateType(it, argument)
            }.filter { it }.isNotEmpty()

            if(!isValidArgument) {
                val requiredType = required.allowType.map { it.name }.joinToString("/")
                System.err.println("Command '${command.getName()}' requires an argument '${required.name}'(${requiredType} required)")
                exitProcess(1)
            }
        }
    }
}