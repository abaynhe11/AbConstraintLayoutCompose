package com.google.firebase.quickstart.auth.abconstraintlayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.firebase.quickstart.auth.abconstraintlayoutcompose.ui.theme.AbConstraintLayoutComposeTheme
import kotlinx.coroutines.NonDisposableHandle.parent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbConstraintLayoutComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  MainScreen()
                }
            }
        }
    }
}
@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier
    ) {
        Text(text)
    }
}

@Composable
fun MainScreen() {
    ConstraintLayout(Modifier.size(width = 400.dp, height = 100.dp)) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })
    }

    ConstraintLayout(Modifier.size(width = 400.dp, height = 100.dp)) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3,
            chainStyle = ChainStyle.SpreadInside)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })
        }


    ConstraintLayout(Modifier.size(width = 400.dp, height = 220.dp)) {
        val (button1, button2, button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = .60f)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            top.linkTo(parent.top, margin = 30.dp)
            end.linkTo(guide, margin = 30.dp)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            top.linkTo(button1.bottom, margin = 20.dp)
            start.linkTo(guide, margin = 40.dp)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            top.linkTo(button2.bottom, margin = 40.dp)
            end.linkTo(guide, margin = 20.dp)
        })
    }
   ConstraintLayout(Modifier.size(width = 350.dp, height = 220.dp)) {
        val (button1, button2, button3) = createRefs()

        MyButton(text = "Button1", Modifier.width(100.dp).constrainAs(button1) {
            top.linkTo(parent.top, margin = 30.dp)
            start.linkTo(parent.start, margin = 8.dp)
        })

        MyButton(text = "Button2", Modifier.width(100.dp).constrainAs(button2) {
            top.linkTo(button1.bottom, margin = 20.dp)
            start.linkTo(parent.start, margin = 8.dp)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            linkTo(parent.top, parent.bottom,
                topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp,
                endMargin = 8.dp)
        })  
        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

    }

    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
        val button1 = createRef()

        MyButton(text = "Button1", Modifier.size(200.dp).constrainAs(button1) {
            linkTo(parent.top, parent.bottom, topMargin = 8.dp,
                bottomMargin = 8.dp)
            linkTo(parent.start, parent.end, startMargin = 8.dp,
                endMargin = 8.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AbConstraintLayoutComposeTheme {
        MainScreen()

    }
}