package id.ac.atmaluhur.contohwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Belajar Widget"

        val etNama = findViewById<EditText>(R.id.etNama)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val rdLaki = findViewById<RadioButton>(R.id.rdLaki)
        val rdPerempuan = findViewById<RadioButton>(R.id.rdPerempuan)
        val chBaca = findViewById<CheckBox>(R.id.chBaca)
        val chMasak = findViewById<CheckBox>(R.id.chMasak)
        val chBola = findViewById<CheckBox>(R.id.chBola)
        val chNyanyi = findViewById<CheckBox>(R.id.chNyanyi)
        val spnKerja = findViewById<Spinner>(R.id.spnKerja)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        //Menambahkan item ke Spinner
        val pekerjaan = arrayOf("--Pilih--", "Guru", "Dosen", "Mahasiswa", "PNS",
            "Mengurus rumah tangga", "Karyawan", "Pustakawan", "Wiraswasta")
        val adpPekerjaan = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            pekerjaan
        )
        spnKerja.adapter = adpPekerjaan

        btnSimpan.setOnClickListener {
            Toast.makeText(this@MainActivity, when {
                "${etNama.text}".isEmpty() -> "Nama belum diisi"
                "${etAlamat.text}".isEmpty() -> "Alamat belum diisi"
                !rdLaki.isChecked && !rdPerempuan.isChecked -> "Jenis kelamin belum dipilih"
                !chBaca.isChecked && !chMasak.isChecked && !chBola.isChecked && !chNyanyi.isChecked -> "Hobi belum dipilih"
                spnKerja.selectedItem == "--Pilih--" -> "Pekerjaan belum dipilih"
                else -> "Biodata pribadi tersimpan"
            }, Toast.LENGTH_SHORT).show()
        }
    }
}