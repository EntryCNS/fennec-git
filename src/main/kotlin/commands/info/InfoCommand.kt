package commands.info

import commands.FennecArgument
import commands.FennecCommand

class InfoCommand: FennecCommand() {
    override fun getName(): String = "info"

    override fun getDescription(): String = "fennec의 정보를 확인합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf()

    override fun run(arguments: List<String>) {
        println("fennec - Easy git command line tool")
        println(" * Develop Team: Team CNS(Daegu Software Meister High School)")
        println(" * Develop Members:")
        println("   * SeungMin Lee(github.com/vinto1819)")
    }

}