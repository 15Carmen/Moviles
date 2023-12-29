package com.example.whatssappfirebase.ui.core

import android.app.Activity
import com.example.whatssappfirebase.ui.views.UsersActivity

object Navigator {

    fun navigateToUsersListFrom(activity: Activity) {
        with(activity) {
            startActivity(UsersActivity.newInstance(this))
            finish()
        }
    }

}