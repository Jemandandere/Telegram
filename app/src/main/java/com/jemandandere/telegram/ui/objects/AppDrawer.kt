package com.jemandandere.telegram.ui.objects

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import com.jemandandere.telegram.App
import com.jemandandere.telegram.R
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(val context: Activity, val toolbar: Toolbar) {
    private var id: Long = 100
    private lateinit var header: AccountHeader
    private lateinit var drawer: Drawer

    fun create() {
        header = getHeader()
        drawer = getDrawer()
    }

    private fun getHeader(): AccountHeader {
        return AccountHeaderBuilder()
            .withActivity(context)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName(context.getString(R.string.default_username))
                    .withEmail(context.getString(R.string.default_phone_number))
            )
            .build()
    }

    private fun getDrawer(): Drawer {
        return DrawerBuilder()
            .withActivity(context)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withActionBarDrawerToggleAnimated(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems(
                getMenuItem(R.string.create_group, R.drawable.ic_menu_create_groups),
                getMenuItem(R.string.create_secret_chat, R.drawable.ic_menu_secret_chat),
                getMenuItem(R.string.create_channel, R.drawable.ic_menu_create_channel),
                getMenuItem(R.string.contacts, R.drawable.ic_menu_contacts),
                getMenuItem(R.string.calls, R.drawable.ic_menu_phone),
                getMenuItem(R.string.favorites, R.drawable.ic_menu_favorites),
                getMenuItem(R.string.settings, R.drawable.ic_menu_settings),
                DividerDrawerItem(),
                getMenuItem(R.string.invite, R.drawable.ic_menu_invate),
                getMenuItem(R.string.help, R.drawable.ic_menu_help)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> App.instance.navController.navigate(R.id.action_chatListFragment_to_settingsFragment)
                        else -> Toast.makeText(context ,position.toString(),Toast.LENGTH_SHORT).show()
                    }
                    return false
                }
            })
            .build()
    }

    private fun getMenuItem(@StringRes text: Int, @DrawableRes icon: Int): PrimaryDrawerItem {
        return PrimaryDrawerItem()
            .withIdentifier(id++)
            .withSelectable(false)
            .withName(context.getString(text))
            .withIcon(icon)
            .withIconTintingEnabled(true)
    }
}