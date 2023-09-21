package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val awal = binding.editNilai1.text.toString()
    val kedua = binding.editNilai2.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambah.setOnClickListener {
            val awal = binding.editNilai1.text.toString().toInt()
            val kedua = binding.editNilai2.text.toString().toInt()
            validasi(awal,kedua,'+')
        }

        binding.btnKurang.setOnClickListener {
            val awal = binding.editNilai1.text.toString().toInt()
            val kedua = binding.editNilai2.text.toString().toInt()
            validasi(awal,kedua,'-')
        }

        binding.btnBagi.setOnClickListener {
            val awal = binding.editNilai1.text.toString().toInt()
            val kedua = binding.editNilai2.text.toString().toInt()
            validasi(awal,kedua,':')
        }

        binding.btnKali.setOnClickListener {
            val awal = binding.editNilai1.text.toString().toInt()
            val kedua = binding.editNilai2.text.toString().toInt()
            validasi(awal,kedua,'x')
        }
    }

    private fun validasi(awal: Int, kedua: Int, operator: Char){
        if(awal.isEmpty()){
            binding.editNilai1.error = "Isi Dulu Yaaaa"
        }
        if(kedua.isEmpty()){
            binding.editNilai1.error = "Isi Dulu Yaaaa"
        }
        if(awal.isNotEmpty() && kedua.isNotEmpty()){
            perhitungan(awal.toDouble(), kedua.toDouble(), operator)
        }
    }

    private fun perhitungan(awal: Double, kedua: Double, operator: Char){
        var hasil = 0.0
        if(operator == '-'){
            hasil = awal - kedua
        }else if(operator == '+'){
            hasil = awal + kedua
        }else if(operator == ':'){
            hasil = awal / kedua
        }else if(operator == 'x'){
            hasil = awal * kedua
        }

        binding.tvHasil.text = hasil.toString()
    }
}