package com.kersnazzle.soundscapealpha.screens.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kersnazzle.soundscapealpha.R
import com.kersnazzle.soundscapealpha.components.OnboardButton
import com.kersnazzle.soundscapealpha.screens.navigation.Screens
import com.kersnazzle.soundscapealpha.ui.theme.IntroTypography
import com.kersnazzle.soundscapealpha.ui.theme.IntroductionTheme
import com.kersnazzle.soundscapealpha.ui.theme.SoundscapeTheme

@Composable
fun Welcome(navController: NavHostController) {
    IntroductionTheme {
        MaterialTheme(typography = IntroTypography) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.soundscape_alpha_1024),
                    contentDescription = stringResource(R.string.first_launch_welcome_title_accessibility_label),
                    modifier = Modifier
                        .padding(24.dp)
                        .clip(RoundedCornerShape(90.dp))
                )

                Spacer(modifier = Modifier.height(50.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.first_launch_welcome_title),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(R.string.first_launch_welcome_description),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Column(modifier = Modifier.padding(horizontal = 50.dp)) {
                        OnboardButton(
                            text = stringResource(R.string.ui_continue),
                            onClick = { navController.navigate(Screens.Language.route) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewWelcome() {
    SoundscapeTheme {
        Welcome(navController = rememberNavController())
    }
}