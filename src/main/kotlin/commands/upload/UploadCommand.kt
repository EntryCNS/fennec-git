package commands.upload

import commands.ArgumentType
import commands.FennecArgument
import commands.FennecCommand
import git.GitWrapper

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

        val emoji = CommitType.valueOf(arguments[0]).emoji
        val commitTitle = "$emoji ${arguments[1]}"
        val commitDescription = arguments.getOrNull(2)

        val gitWrapper = GitWrapper()
        gitWrapper.commit(commitTitle, commitDescription)
        //gitWrapper.push()

        println("Committed and pushed into branch ${gitWrapper.getCurrentBranch()} successfully.")
    }

}