package commands

import commands.branch.create.CreateBranchCommand
import commands.help.HelpCommand
import commands.upload.UploadCommand
import kotlin.system.exitProcess

class CommandMapper {
    companion object {
        val map: Map<String, FennecCommand> = mapOf(
            "upload" to UploadCommand(),
            "flow" to CreateBranchCommand(),
            "help" to HelpCommand()
        )

        fun execute(args: Array<String>) {
            if(args.size == 0) {
                CommandHelper.printHelp()
                exitProcess(1)
            }

            try {
                val command = map.get(args[0])!!
                val slicedArgs = args.slice(1 until args.size)

                ArgumentValidator(command, slicedArgs).validate()
                command.run(slicedArgs)
            }catch (ex: Exception) {
                System.err.println("No such command '${args[0]}' Reference this:")
                CommandHelper.printHelp()
            }
        }

    }
}