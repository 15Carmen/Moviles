package com.example.contactlistroom

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.contactlistroom.entidades.ContactsEntity

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val repository : ContactRepository

    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactsDao()
        repository = ContactRepository(dao)
    }

    suspend fun addContacts(contactsEntity: ContactsEntity){
        repository.insertContact(contactsEntity)
    }

    suspend fun getAllContacts() : LiveData<List<ContactsContract.Contacts>> = repository.getAllContacts()
}