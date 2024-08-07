package com.kersnazzle.soundscapealpha.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowOutward
import androidx.compose.material.icons.rounded.DirectionsRun
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kersnazzle.soundscapealpha.R
import com.kersnazzle.soundscapealpha.components.OnboardButton
import com.kersnazzle.soundscapealpha.screens.navigation.Screens
import com.kersnazzle.soundscapealpha.ui.theme.IntroTypography
import com.kersnazzle.soundscapealpha.ui.theme.IntroductionTheme

@Composable
fun Navigating(navController: NavHostController) {

    val continueOnboard = {
        navController.navigate(Screens.AudioBeacons.route)
    }

    var showCheck by remember { mutableStateOf(false) }

    IntroductionTheme {
        MaterialTheme(typography = IntroTypography) {
            /*if (showCheck)
                SoundscapePermissionCheck(continueOnboard)*/

            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 100.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            )
            {
                Text(
                    text = stringResource(id = R.string.first_launch_permissions_title),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(id = R.string.first_launch_permissions_message),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.Black.copy(alpha = 0.4f))
                )
                {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = stringResource(R.string.first_launch_permissions_location),
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.first_launch_permissions_required),
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),
                    )
                    {
                        Icon(
                            Icons.Rounded.Notifications,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                // Notification permission doesn't have translations as
                                // original iOS Soundscape didn't have this
                                text = stringResource(R.string.first_launch_permissions_notification),
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.first_launch_permissions_required),
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                    )
                    {
                        Icon(
                            Icons.Rounded.FitnessCenter,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                // iOS has Motion and Fitness and Android has Activity Recognition but
                                // I'm reusing the original translation strings
                                text = stringResource(R.string.first_launch_permissions_motion),
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.first_launch_permissions_required),
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }

                Spacer(modifier = Modifier.height(150.dp))

                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    OnboardButton(
                        text = stringResource(R.string.ui_continue),
                        onClick = { showCheck = true },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NavigatingPreview() {
    Navigating(navController = rememberNavController())
}