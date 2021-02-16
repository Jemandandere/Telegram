package com.jemandandere.telegram.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jemandandere.telegram.App
import com.jemandandere.telegram.R
import com.jemandandere.telegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        App.instance.navController = Navigation.findNavController(this, R.id.navigation_controller)
        NavigationUI.setupActionBarWithNavController(this, App.instance.navController)
        createHeader()
        createDrawer()
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName(getString(R.string.default_username))
                    .withEmail(getString(R.string.default_phone_number))
            )
            .build()
    }

    private fun createDrawer() {
        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withActionBarDrawerToggleAnimated(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems(
                PrimaryDrawerItem()
                    .withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.create_group))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups),
                PrimaryDrawerItem()
                    .withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.create_secret_chat))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),
                PrimaryDrawerItem()
                    .withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.create_channel))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem()
                    .withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.contacts))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),
                PrimaryDrawerItem()
                    .withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.calls))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_phone),
                PrimaryDrawerItem()
                    .withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.favorites))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem()
                    .withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.settings))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),
                DividerDrawerItem(),
                PrimaryDrawerItem()
                    .withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.invite))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem()
                    .withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.help))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_help)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> App.instance.navController.navigate(R.id.action_chatListFragment_to_settingsFragment)
                        else -> Toast.makeText(
                            applicationContext,
                            position.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    return false
                }
            })
            .build()
    }

}