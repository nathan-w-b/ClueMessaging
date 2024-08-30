package com.example.cluemessaging.ui.composable_lib

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cluemessaging.R
import com.example.cluemessaging.ui.theme.ClueMessagingTheme

@Composable
fun LibText(textVal: String, centered: Boolean = false, textColor: Color? = null) {
    val textAlignment = if (centered) TextAlign.Center else TextAlign.Start
    if (textColor == null)
        Text(
            text = textVal,
    //        modifier = Modifier.fillMaxWidth(),
            textAlign = textAlignment)
    else
        Text(
            text = textVal,
            textAlign = textAlignment,
            color = textColor)
}

@Composable
fun LibTextDescription(textVal: String, centered: Boolean = false) {
    val textAlignment = if (centered) TextAlign.Center else TextAlign.Start
    Text(
        text = textVal,
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Light,
        textAlign = textAlignment)
}

@Composable
fun LibTextFocus(textVal: String, title:Boolean = true, centered: Boolean = true) {
    val textAlign = if (centered) TextAlign.Center else TextAlign.Start
    val titleStyle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
    val textStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        textAlign = textAlign
    )
    val style = if (title) titleStyle else textStyle

    Text(
        text = textVal,
        modifier = Modifier.fillMaxWidth(),
        style = style
    )
}

@Composable
fun LibTextBadge(imageId: Int, titleString: String, textString: String){
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)) {
        Image(
            modifier = Modifier
                .size(44.dp)
                .padding(6.dp),
            painter = painterResource(imageId),
            contentDescription = titleString)
        Column (
            modifier = Modifier.padding(6.dp)
        ) {
            LibText(textVal = titleString)
            Spacer(modifier = Modifier.height(2.dp))
            LibTextDescription(textVal = textString)
        }
    }
}

@Composable
fun LibTextField(labelValue: String,
                 initValue: String = "",
                 leadingIconId: Int? = null,
                 keyboard: KeyboardType? = null,
                 onValueChangeFunction: ((String) -> Unit)? = null){
    var leadingIconVal: @Composable (() -> Unit)? = null
    if (leadingIconId != null)
        leadingIconVal = {
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = leadingIconId),
                contentDescription = "")
        }
    val keyboardOptions: KeyboardOptions = if (keyboard != null) KeyboardOptions(
        keyboardType = keyboard) else KeyboardOptions.Default

    TextField(
        modifier = Modifier
//            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.LightGray,
            unfocusedContainerColor = Color.Transparent),
        label = {Text(text = labelValue)},
        value = initValue,

        keyboardOptions = keyboardOptions,
        onValueChange = onValueChangeFunction?: {},
        leadingIcon = leadingIconVal
    )
}

@Composable
fun LibTextFieldOutlined(labelValue: String,
                         initValue: String = "",
                         leadingIconId: Int? = null,
                         onValueChangeFunction: ((String) -> Unit)? = null){
    var leadingIconVal: @Composable (() -> Unit)? = null
    if (leadingIconId != null)
        leadingIconVal = {
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = leadingIconId),
                contentDescription = "")
        }

    OutlinedTextField(
        modifier = Modifier
//            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        value = initValue,
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = onValueChangeFunction?: {},
        leadingIcon = leadingIconVal
    )
}

@Composable
fun LibTextFieldPassword(labelValue: String = "Password", initValue: String = "", onValueChangeFunction: ((String) -> Unit)? = null){
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        value = initValue,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = onValueChangeFunction?: {},
        leadingIcon = {
            Icon(painter = painterResource(id = R.mipmap.password), contentDescription = "")
        },
        trailingIcon = {
            val visibilityId = if(passwordVisible.value){
                R.drawable.ic_visible
            } else {
                R.drawable.ic_visible_off
            }
            val description = if (passwordVisible.value){
                "Hide password"
            } else {
                "Show password"
            }
            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(painter = painterResource(id = visibilityId), contentDescription = description)
            }
        },
        visualTransformation =
        if(passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibComboField(optionsList: Array<String>, width: Dp = 0.dp, onValueChangeFunction: ((String) -> Unit)? = null) {
    var selectedValue by remember { mutableStateOf(optionsList[0]) }
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
//        modifier = Modifier.width(IntrinsicSize.Min),
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }
    ){
        if (width == 0.dp) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .clip(RoundedCornerShape(4.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.Transparent),
                value = selectedValue,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded) }
            )
        }
        else {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .width(width)
                    .clip(RoundedCornerShape(4.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.Transparent),
                value = selectedValue,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded) }
            )
        }
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {isExpanded = false}) {
            optionsList.forEachIndexed{ index, value ->
                DropdownMenuItem(
                    text = { Text(text = value) },
                    onClick = {
                        selectedValue = optionsList[index]
                        isExpanded = false
                        onValueChangeFunction?.invoke(selectedValue)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

@Composable
fun LibButton(textVal: String, fillWidth: Boolean = false, onClickFunction: () -> Unit){
    Button(
        modifier = if (fillWidth) Modifier.fillMaxWidth() else Modifier,
        onClick = onClickFunction
    ) {
        LibText(textVal, true)
    }
}

@Composable
fun LibButtonImage(imageId: Int, onClickFunction: () -> Unit){
    Button(
        onClick = onClickFunction,
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Image(painter = painterResource(imageId), contentDescription = "")
    }
}

@Composable
fun LibButtonBadge(imageId: Int, titleString: String,
                   textString: String, onClickFunction: () -> Unit){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent, MaterialTheme.colorScheme.onBackground),
        border = BorderStroke(0.dp, Color.Transparent),
        onClick = onClickFunction) {
        Row( modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(imageId),
                contentDescription = titleString)
            Column () {
                LibText(textVal = titleString)
                LibTextDescription(textVal = textString)
            }
        }
    }
}

@Composable
fun LibButtonFocus(buttonText: String, onClickFunction: () -> Unit) {
    Button(onClick = onClickFunction,
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.inversePrimary
                    )
                ),
                shape = RoundedCornerShape(12.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(text = buttonText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LibClickableText(textVal: String, centered: Boolean = false, onClickFunction: (String) -> Unit) {
    val textAlignmentStyle =
        if (centered) TextStyle(textAlign = TextAlign.Center)
        else TextStyle(textAlign = TextAlign.Start)

    val annotatedString = buildAnnotatedString {
        //append("Firstly, ")
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = textVal, annotation = textVal)
            append(textVal)
        }
    }

    ClickableText(text = annotatedString, style = textAlignmentStyle, onClick = { offset: Int ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also{ span ->
                Log.d("ClickableTextComponent", "{$span}")
                if (span.item == textVal){
                    onClickFunction(span.item)
                }
            }
    })
}

@Composable
fun LibDividerText(textString: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically){
        HorizontalDivider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp)

        Text(text = textString, fontSize = 16.sp, color = Color.DarkGray,
            modifier = Modifier.padding(8.dp))

        HorizontalDivider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp)
    }
}

@Composable
fun LibCheckbox(textString: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        verticalAlignment = Alignment.CenterVertically) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value != checkedState.value
            }
        )
        LibText(textString, false)
    }
}

@Preview(showSystemUi = true)
@Composable
fun LibPreview(){
    ClueMessagingTheme {
        Column () {
            LibTextFocus("LibTextFocus")
            LibTextFocus("LibTextFocus - Non Title", false)
            LibText("LibText")
            LibTextBadge(imageId = R.drawable.ic_notifications, titleString = "Lib Text Badge", textString = "Dummy Badge String")
            LibClickableText(textVal = "Lib Clickable Text", true) {}
            LibTextField("Lib Text Field", leadingIconId = R.drawable.ic_phone)
            LibTextFieldOutlined("Lib Text Field Outlined", leadingIconId = R.mipmap.email)
            LibTextFieldPassword("Lib Text Field Password")
            LibButton("Dummy Button") {}
            LibButton("Dummy Large Button", true) {}
            LibButtonBadge(imageId = R.drawable.ic_launcher_foreground, titleString = "Dummy Button", textString = "This is a dummy image button for the preview.") {}
            LibDividerText(textString = "Or")
            LibButtonFocus(buttonText = "Focus") {}
            LibCheckbox("Lib Checkbox")
        }
    }
}