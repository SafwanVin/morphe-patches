package app.morphe.patches.podcastaddict.premium

import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.podcastaddict.shared.Constants
import app.morphe.util.returnEarly

@Suppress("unused")
val enablePremiumPatch = bytecodePatch(
    name = "Enable Premium",
    description = "Enables app features locked behind the subscription paywall."
) {
    compatibleWith(Constants.COMPATIBILITY)

    execute {
        HasPremiumFingerprint.method.returnEarly(true)
        IsValidSignatureFingerprint.method.returnEarly(true)
        IsValidPackageSourceFingerprint.method.returnEarly(true)
    }
}