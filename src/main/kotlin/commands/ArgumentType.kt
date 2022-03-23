package commands

import commands.branch.BranchType
import commands.add.AddType
import commands.upload.CommitType

enum class ArgumentType(val description: String) {
    // 기본 타입
    STRING("문자열"), NUMBER("숫자"), DIRECTORY("폴더"),

    // ENUM 타입
    ENUM_COMMITTYPE(CommitType.values().joinToString("/") { it.name }),
    ENUM_ADDTYPE(AddType.values().joinToString("/") { it.name }),
    ENUM_BRANCHTYPE(BranchType.values().joinToString("/") { it.name })
}