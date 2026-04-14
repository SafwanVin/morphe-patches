package app.morphe.patches.macrofactor.shared

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY = Compatibility(
        name = "Macro Factor",
        packageName = "com.sbs.diet",
        appIconColor = 0x000000,
        targets = listOf(AppTarget("5.7.6"))
    )
}