package com.example.android4a_aurelienandrieux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // private val/var nameVariable : Type = value
    // val is final, var is modifiable
    // private fun nameFunction(a : Type, b: Type, c: Type = defaultValue) : TypeReturn { return variable }
    // Kotlin --> extend & interface = : (e.g class test : oui()) ; must write open before the class to extend
    // enum class a{ value1, value2, ...}
    // switch is when(variable){ a.value1 -> action     a.value2, a.value3 -> action ...}
    // Else, we can do when{ condition1 && condition2 == 3 -> Unit  condition1 && condition2 < 2 ...
    // Data class nameDataClass(val nameVar1 : type1, val nameVar2 : type2...)
    // To call data class -> nameDataClass(nameVar1 = "test", nameVar2="test2") ; To set/get a value, simply do nameDataClass.nameVar1 = ...
    // Sealed class to control the inheritance. Define objects that extend the sealed class
    // Can call sealed class in a when
    // "is" to verify that the type of the object is right; as to cast the object as a certain type
    // If variable can be null, type of the variable is Type?
    // If Type?, can check operations on the variable like val test = variable?.operation() ?: "" | if variable isn't null, do the operation, else is what after ?:
    // Can create extension functions, by putting like Type.nameFunction
    // Extension functions allows to do simple things like capitalize the first letter of a string or whatever
    // Can place those functions where you want, might as well create it in an extension file
    // Put all static variables (variables you can use without creating an instance of the class) in a companion object
    // companion object { val ...}
    // To define a constant, use the key word const (E.G const val test)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}