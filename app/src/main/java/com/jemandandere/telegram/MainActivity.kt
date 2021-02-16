package com.jemandandere.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
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
                                .withName(getString(R.string.group_create))
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_groups),
                        PrimaryDrawerItem()
                                .withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Создать секретный чат")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_secret_chat),
                        PrimaryDrawerItem()
                                .withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Создать канал")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_channel),
                        PrimaryDrawerItem()
                                .withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Контакты")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_contacts),
                        PrimaryDrawerItem()
                                .withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Звонки")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_phone),
                        PrimaryDrawerItem()
                                .withIdentifier(105)
                                .withIconTintingEnabled(true)
                                .withName("Избранное")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_favorites),
                        PrimaryDrawerItem()
                                .withIdentifier(106)
                                .withIconTintingEnabled(true)
                                .withName("Настройки")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_settings),
                        DividerDrawerItem(),
                        PrimaryDrawerItem()
                                .withIdentifier(107)
                                .withIconTintingEnabled(true)
                                .withName("Пригласить друзей")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_invate),
                        PrimaryDrawerItem()
                                .withIdentifier(108)
                                .withIconTintingEnabled(true)
                                .withName("Вопросы о телеграм")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_help)


                )
                .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener{
                    override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                        Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .build()
    }

}