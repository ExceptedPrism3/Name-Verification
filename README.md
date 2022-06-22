# Name-Verification

![Updated Badge](https://badges.pufler.dev/updated/ExceptedPrism3/Name-Verification)
![Version](https://img.shields.io/github/v/release/ExceptedPrism3/Name-Verification)
![Downloads](https://img.shields.io/github/downloads/ExceptedPrism3/Name-Verification/total)
![Issues](https://img.shields.io/github/issues/ExceptedPrism3/Name-Verification)
[![Discord](https://img.shields.io/discord/850407951629287424)](https://discord.gg/MfR5mcpVfX)

A spigot plugin that checks the Player's Name for any inappropriate words
and or if they're whitelisted and therefore kicks them with a Message!

This plugin can be found at [Spigot](https://www.spigotmc.org/resources/nameverif.95719/)
and [MC-Market](https://www.mc-market.org/resources/21092/).

Plugin's Wiki can be found [**here**](https://prism3.gitbook.io/nameverification/).

If support is needed or a suggesting that needs to be implemented, feel free to ask on the [Discord](https://discord.gg/MfR5mcpVfX), also do not forget to check out the plugin's **[Wiki](https://prism3.gitbook.io/nameverification/)**.

# About the Plugin
This Plugin Checks for Player Names for any Inappropriate Names Listed
or if they exist in a whitelist in the **config.yml** field and Kicks them with a Message.

**It can also check for Bedrock Usernames!**

This Plugin is mainly meant for Offline-Mode Server **aka**
Cracked Servers as users can access with any name.

# Commands
- /nameverif list-blacklist - List all blacklisted names
- /nameverif add-blacklist "name" - Add the given name into the blacklist field
- /nameverif remove-blacklist "name" - Remove the given name from the blacklist field
- /nameverif list-whitelist - List all whitelisted names
- /nameverif add-whitelist "name" - Add the given name into the whitelist field
- /nameverif remove-whitelist "name" - Remove the given name from the whitelist field
- /nameverif toggle - Toggle Whitelist Mode
- /nameverif reload - Reload the Config

# Permissions
- nameverif.admin - Ability to List, Add, Remove, Toggle, and Reload
- nameverif.bypass - Bypass the Checkers