package me.mical.custompapi.entity

import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class CPPlayer constructor(private val player: OfflinePlayer) {
    fun hasData() : Boolean = CustomPapi.cp_dataMap.containsKey(player.uniqueId)
    fun initData() {
        if (!(CustomPapi.cp_dataMap.containsKey(player.uniqueId) || File(CustomPapi.getCPFolder().getCPFolderFile(), "${player.uniqueId}.yml").exists())) {
            CustomPapi.getCPFolder().initPlayerData(player.uniqueId)
            CustomPapi.cp_dataMap[player.uniqueId] = YamlConfiguration.loadConfiguration(File(CustomPapi.getCPFolder().getCPFolderFile(), "${player.uniqueId}.yml"))
            TLocale.sendToConsole("InitedData", player.uniqueId.toString())
        }
    }
}