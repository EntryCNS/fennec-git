package commands

abstract class FennecCommand {
    abstract fun getName(): String
    abstract fun getDescription(): String
    abstract fun getRequiredArguments(): List<FennecArgument>

    abstract fun run(arguments: List<String>)
}