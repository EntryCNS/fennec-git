package commands.upload

import commands.ArgumentType
import commands.FennecArgument
import commands.FennecCommand

class UploadCommand: FennecCommand() {
    override fun getName(): String = "upload"

    override fun getDescription(): String = "git commit 및 push를 진행합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf(
        FennecArgument("메시지 타입(${CommitType.values().map { it.name }.joinToString("/")})", listOf(ArgumentType.ENUM_COMMITTYPE)),
        FennecArgument("메시지 제목", listOf(ArgumentType.STRING)),
        FennecArgument("메시지 바디", listOf(ArgumentType.STRING), true)
    )

    override fun run(arguments: List<String>) {
        println(arguments.joinToString(" / "))
    }

}