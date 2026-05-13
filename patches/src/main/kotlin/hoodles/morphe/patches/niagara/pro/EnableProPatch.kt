package hoodles.morphe.patches.niagara.pro

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.bytecodePatch

val enableProPatch = bytecodePatch(
    name = "Enable Niagara Pro",
    description = "Enables app features locked behind the subscription paywall."
) {
    compatibleWith(Compatibility(
        name = "Niagara Launcher",
        packageName = "bitpit.launcher",
        appIconColor = 0x9fcdfb,
        targets = listOf(AppTarget("1.16.4"))
    ))

    execute {
        ProStateConstructorFingerprint.method.addInstructions(0, """
            const/4 p1, 0x1
            const/4 p2, 0x1
        """.trimIndent())
    }
}