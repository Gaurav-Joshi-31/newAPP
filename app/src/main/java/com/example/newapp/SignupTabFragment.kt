package com.example.newapp


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_signup_tab.*

class SignupTabFragment : Fragment(R.layout.fragment_signup_tab) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnSignUp.setOnClickListener {
            when {
                TextUtils.isEmpty(textEmailAddress.text.toString().trim { it <= ' ' }) -> {
                   Toast.makeText(activity,"Please enter email",Toast.LENGTH_LONG).show()
                }

                TextUtils.isEmpty(textPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(activity, "Please enter password", Toast.LENGTH_SHORT).show()
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(textEmailAddress.text.toString().trim { it <= ' ' }).matches() -> {
                    Toast.makeText(activity, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                }

                else ->{
                    progrssBar.visibility= View.VISIBLE
                    btnSignUp.isEnabled= false
                    val email: String=textEmailAddress.text.toString().trim { it <= ' ' }
                    val passwd: String=textPassword.text.toString().trim { it <= ' ' }
                    activity?.let { it1 ->
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,passwd)
                            .addOnCompleteListener(it1) { task ->

                                if(task.isSuccessful){
                                    Toast.makeText(activity, "You were registered successfully", Toast.LENGTH_SHORT).show()

                                    val intent= Intent(activity, MainActivity::class.java)
                                    startActivity(intent)
                                } else{
                                    progrssBar.visibility= View.GONE
                                    btnSignUp.isEnabled= true
                                    Toast.makeText(activity, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                                }

                            }
                    }
                }

            }
        }
    }
}