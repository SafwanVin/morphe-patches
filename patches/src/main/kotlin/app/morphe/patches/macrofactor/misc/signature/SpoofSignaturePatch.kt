package app.morphe.patches.macrofactor.misc.signature

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.macrofactor.shared.Constants
import app.morphe.util.byteArrayOf

val SIGNATURE = byteArrayOf("72 80 3C E3 0B 7F 47 E8 4D 86 98 7F 45 1D AF 8C 7A CC B5 A0")

val spoofSignaturePatch = bytecodePatch(
    name = "Spoof signature",
    description = "Spoof package signature for Firebase app check."
) {
    compatibleWith(Constants.COMPATIBILITY)

    execute {
        GetSignatureFingerprint.method.apply {
            addInstructions(0, """
                const/16 v0, ${SIGNATURE.size}
                new-array v0, v0, [B
                fill-array-data v0, :array_sig
                return-object v0

                :array_sig
                .array-data 1
                    ${SIGNATURE.joinToString("\n") { "${it}t" }}
                .end array-data
            """.trimIndent())
        }
    }

}