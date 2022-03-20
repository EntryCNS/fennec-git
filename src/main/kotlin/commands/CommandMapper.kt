package commands

import commands.upload.UploadCommand
import kotlin.system.exitProcess

class CommandMapper {
    companion object {
        val map: Map<String, FennecCommand> = mapOf(

        )

        fun execute(args: Array<String>) {
            if(args.size == 0) {
                System.out.println("Command required.")
                exitProcess(1)
            }

            try {
                val command = map.get(args[0])!!
                val args = args.slice(1 until args.size)

                ArgumentValidator(command, args).validate()
                command.run(args)
            }catch (ex: Exception) {
                ex.printStackTrace()
                System.err.println("Command '${args[0]}' not found.")
            }
        }

    }
}