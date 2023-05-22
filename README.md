# Name-Verification

![Updated Badge](https://badges.pufler.dev/updated/ExceptedPrism3/Name-Verification)
![Version](https://img.shields.io/github/v/release/ExceptedPrism3/Name-Verification)
![Downloads](https://img.shields.io/github/downloads/ExceptedPrism3/Name-Verification/total)
![Issues](https://img.shields.io/github/issues/ExceptedPrism3/Name-Verification)
[![Discord](https://img.shields.io/discord/850407951629287424)](https://discord.gg/MfR5mcpVfX)
[![Open Source](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://opensource.org/)

A Spigot plugin that checks the player's name for any inappropriate words and/or if they are whitelisted, and then kicks them with a message!

This plugin can be found at [Spigot](https://www.spigotmc.org/resources/nameverif.95719/)
and [MC-Market](https://www.mc-market.org/resources/21092/).

Plugin's Wiki can be found [**here**](https://prism3.gitbook.io/nameverification/).

If support is needed or a suggesting that needs to be implemented, feel free to ask on [Discord](https://discord.gg/MfR5mcpVfX), also do not forget to check out the plugin's **[Wiki](https://prism3.gitbook.io/nameverification/)**.

# About the Plugin
This Plugin Checks for Player Names for any Inappropriate Names Listed
or if they exist in a whitelist in the **config.yml** field and Kicks them with a Message.

**It can also check for Bedrock Usernames!**

This Plugin is mainly meant for Offline-Mode Server **aka**
Cracked Servers as users can access with any name.

# Commands
- /nameverif list <blacklist OR whitelist> - List all desired type's names
- /nameverif modifylist <add OR remove> <whitelist OR blacklist> <name> - Add the given name into the blacklist field
- /nameverif toggle - Toggle Whitelist Mode
- /nameverif reload - Reload the Config

# Permissions
- nameverif.admin - Ability to List, Add, Remove, Toggle, and Reload
- nameverif.bypass - Bypass the Checkers