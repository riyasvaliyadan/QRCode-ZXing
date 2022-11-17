import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import java.awt.GridLayout
import java.awt.event.ActionListener
import java.awt.image.BufferedImage
import java.nio.file.FileSystems
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

fun main(args: Array<String>) {
    val data = "Riyas Valiyadan"
    val bufferedImage = generateQR(data, "qrCode.png",200,200)
    display(bufferedImage)
    println("QR Code Generated!!! ")
}

// Function to create the QR code
fun generateQR(data: String, fileName: String, width: Int, height: Int): BufferedImage? {
    val bitMatrix: BitMatrix = MultiFormatWriter().encode(
        data,
        BarcodeFormat.QR_CODE,
        width,
        height
    )
    val path = FileSystems.getDefault().getPath(fileName)
//    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path)
    return MatrixToImageWriter.toBufferedImage(bitMatrix)
}

fun display(bufferedImage: BufferedImage?) {
    val frame = JFrame()
    frame.setLocationRelativeTo(null)
    frame.add(JLabel(ImageIcon(bufferedImage)))
    frame.pack()
    frame.isVisible = true
}
