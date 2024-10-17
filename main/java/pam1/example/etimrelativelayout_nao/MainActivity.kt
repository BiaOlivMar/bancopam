package pam1.example.etimrelativelayout_nao

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pam1.example.etimrelativelayout_nao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //listener vai ficaar ouvindo o teclado pra ver onde vai clicar
        binding.imageSaldo.setOnClickListener{
            //clicando na imagem, ela vai criar uma intenção de mudar de tela com o Intent
            val mudarDeTela = Intent(this, Saldo::class.java)
            //o Intent precisa saber a tela que estamos e a tela que queremos ir

            //o startActivity efetivamente muda de tela
            startActivity(mudarDeTela)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}