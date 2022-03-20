package commands

data class FennecArgument(
    val name: String,
    val allowType: List<ArgumentType>,
    val optional: Boolean = false
)