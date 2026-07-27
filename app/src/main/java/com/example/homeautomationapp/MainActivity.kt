package com.example.homeautomationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.homeautomationapp.ui.theme.HomeAutomationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeAutomationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeAutomationAppTheme {package com.example.homeautomation

        import android.content.Context
                import android.media.MediaPlayer
                import android.util.AttributeSet
                import android.view.LayoutInflater
                import android.widget.FrameLayout
                import android.widget.ImageView
                import android.widget.Switch
                import com.example.homeautomation.R

        class ApplianceSwitchView @JvmOverloads constructor(
            context: Context, attrs: AttributeSet? = null
        ) : FrameLayout(context, attrs) {
            private val switch: Switch
            private val icon: ImageView
            private val soundOn: MediaPlayer = MediaPlayer.create(context, R.raw.switch_on)
            private val soundOff: MediaPlayer = MediaPlayer.create(context, R.raw.switch_off)

            init {
                val view = LayoutInflater.from(context).inflate(R.layout.view_appliance_switch, this, true)
                switch = view.findViewById(R.id.switch_appliance)
                icon = view.findViewById(R.id.icon_appliance)

                switch.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        icon.setImageResource(R.drawable.ic_light_on)
                        soundOn.start()
                        // Animation code here (e.g., fade in, glow)
                    } else {
                        icon.setImageResource(R.drawable.ic_light_off)
                        soundOff.start()
                        // Animation code here (e.g., fade out)
                    }
                }
            }
        }
        Greeting("Android")
    }
}