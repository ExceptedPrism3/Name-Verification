# Name-Verification

![Updated Badge](https://badges.pufler.dev/updated/ExceptedPrism3/Name-Verification)
![Version](https://img.shields.io/github/v/release/ExceptedPrism3/Name-Verification)
![Downloads](https://img.shields.io/github/downloads/ExceptedPrism3/Name-Verification/total)
![Issues](https://img.shields.io/github/issues/ExceptedPrism3/Name-Verification)
[![Discord](https://img.shields.io/discord/850407951629287424)](https://discord.gg/MfR5mcpVfX)
[![Open Source](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://opensource.org/)

## About the Plugin
A Spigot plugin that checks the player's name for any inappropriate words and/or if they are whitelisted, and then kicks them with a message!

This plugin can be found at [Spigot](https://www.spigotmc.org/resources/nameverif.95719/)
and [MC-Market](https://www.mc-market.org/resources/21092/).

Plugin's Wiki can be found [**here**](https://prism3.gitbook.io/nameverification/).

## Features
- Checks the player name for any inappropriate word then kicks them followed by a reason
- AutoBan, the plugin will automatically ban the player if too many attempts the join are reached
- Checks Bedrock player names as well
- Robust regex for a better name checking
- Everything is configurable via the **config.yml**

This Plugin is mainly meant for Offline-Mode Server **aka**
Cracked Servers as users can access with any name.

## Commands
- /nameverif list <blacklist OR whitelist> - List all desired type's names
- /nameverif modifylist <add OR remove> <whitelist OR blacklist> <name> - Add or remove the given name to / from the appropriate field
- /nameverif toggle - Toggle Whitelist Mode
- /nameverif reload - Reload the Config

## Permissions
- nameverif.admin - Ability to List, Add, Remove, Toggle, and Reload
- nameverif.bypass - Bypass the Checkers

## Support
If support is needed or a suggesting that needs to be implemented, feel free to ask on [Discord](https://discord.gg/MfR5mcpVfX), also do not forget to check out the plugin's **[Wiki](https://prism3.gitbook.io/nameverification/)**.

## License

This project is under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing
Contributions are welcome! For major changes, please open an issue or a ticket first to discuss what you would like to change.
