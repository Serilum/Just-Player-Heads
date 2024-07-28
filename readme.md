<h2>Just Player Heads</h2>
<p><a href="https://github.com/Serilum/Just-Player-Heads"><img src="https://serilum.com/assets/data/logo/just-player-heads.png"></a></p><h2>Download</h2>
<p>You can download Just Player Heads on CurseForge and Modrinth:</p><p>&nbsp;&nbsp;CurseForge: &nbsp;&nbsp;<a href="https://curseforge.com/minecraft/mc-mods/just-player-heads">https://curseforge.com/minecraft/mc-mods/just-player-heads</a><br>&nbsp;&nbsp;Modrinth: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://modrinth.com/mod/just-player-heads">https://modrinth.com/mod/just-player-heads</a></p>
<h2>Issue Tracker</h2>
<p>To keep a better overview of all mods, the issue tracker is located in a separate repository.<br>&nbsp;&nbsp;For issues, ideas, suggestions or anything else, please follow this link:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/issue-tracker">Issue Tracker</a></p>
<h2>Pull Requests</h2>
<p>Because of the way mod loader files are bundled into one jar, some extra information is needed to do a PR.<br>&nbsp;&nbsp;A wiki page entry about it is available here:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/pull-requests">Pull Request Information</a></p>
<h2>Mod Description</h2>
<p style="text-align:center"><a href="https://serilum.com/" target="_blank" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/header/header.png" alt="" width="838" height="400"></a></p>
<p style="text-align:center"><a href="https://curseforge.com/members/serilum/projects" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/curseforge.svg" width="200"></a> <a href="https://modrinth.com/user/Serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/modrinth.svg" width="200"></a> <a href="https://patreon.com/serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/patreon.svg" width="200"></a> <a href="https://youtube.com/@serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/youtube.svg" width="200"></a></p>
<p><strong><span style="font-size:24px">Requires the library mod&nbsp;<a style="font-size:24px" href="https://curseforge.com/minecraft/mc-mods/collective" target="_blank" rel="nofollow">Collective</a>.</span></strong><br><br><strong>&nbsp;&nbsp;&nbsp;This mod is part of <span style="color:#008000"><a style="color:#008000" href="https://curseforge.com/minecraft/modpacks/the-vanilla-experience" target="_blank" rel="nofollow">The Vanilla Experience</a></span> modpack and <span style="color:#006b3f"><a style="color:#006b3f" href="https://curseforge.com/minecraft/mc-mods/serilums-rpg-bundle" target="_blank" rel="nofollow">Serilum's RPG Bundle</a></span> mod.</strong><br><span style="font-size:18px">Just Player Heads is a minimalistic mod that allows the collection of player heads via a command or death event. All heads are generated similar to a mob head via texture-data, lag free. The mod procedurally retrieves texture data via the Mojang API, and can cache them locally after.</span><br><br>I've also got a&nbsp;<span style="color:#f90"><a style="color:#f90" href="https://minecraft.curseforge.com/projects/just-mob-heads" rel="nofollow"><strong>Just Mob Heads</strong></a></span>&nbsp;mod available!<br><br><br><strong><span style="font-size:20px">Configurable:</span> <span style="color:#008000;font-size:14px"><a style="color:#008000" href="https://github.com/Serilum/.information/wiki/how-to-configure-mods" rel="nofollow">(&nbsp;how do I configure?&nbsp;)</a></span><br></strong><strong>enablePlayerHeadCaching</strong>&nbsp;(default = true): If enabled, enables the caching of player head textures. This fixes the limitations of the Mojang API, but does mean that whenever players update their skin the old head is still dropped until the server reboots or an administator uses the '/jph cache' command.<br><strong>playerDropsHeadOnDeath</strong>&nbsp;(default = true): If enabled, allows players to drop their head on death.<br><strong>playerHeadDropChance</strong>&nbsp;(default = 1.0, min 0.0001, max 1.0): Sets the chance of a player dropping their head if 'playerDropsHeadOnDeath' is enabled.<br><br><br><strong>Texture values instead of generation via player-names<br></strong>The mod uses texture values to generate the player heads. This means that there won't be any lag, which player-name generated heads usually cause.<strong><br></strong><br><strong>Pure Vanilla Resources<br></strong>Because the mod does not add any custom blocks, you may remove the mod and still have the heads previously gathered in-game.<br><strong><br>In-game commands<br></strong>If you want to generate a player head without any death event, you may do so via the <em>jph&nbsp;</em>command.&nbsp;Where the player name ignores capitalisation and the amount is optional (default amount is 1).<br><em><span style="font-size:18px">/jph head &lt;playerName&gt; (amount)<br></span><br></em>To empty the player head texture cache (if enabled in the config) you can reboot the server or use the following command:<br><span style="font-size:18px"><em>/jph cache</em></span><br><br><strong>Mojang API request limitations<br></strong>The mod uses the&nbsp;<em>UUID -&gt; Profile + Skin/Cape</em> function of the Mojang API. This has quite a strict&nbsp;rate limit: You can request the same profile once per minute, however you can send as many unique requests as you like.&nbsp;<strong>This means that sometimes the mod is unable to generate a head if the API limits its generation.</strong> The texture caching feature can fix this by saving the head texture data locally.</p>
<p><br>------------------<br><br><span style="font-size:24px"><strong>You may freely use this mod in any modpack, as long as the download remains hosted within the CurseForge or Modrinth ecosystem.</strong></span><br><br><span style="font-size:18px"><a style="font-size:18px;color:#008000" href="https://serilum.com/" rel="nofollow">Serilum.com</a> contains an overview and more information on all mods available.</span><br><br><span style="font-size:14px">Comments are disabled as I'm unable to keep track of all the separate pages on each mod.</span><span style="font-size:14px"><br>For issues, ideas, suggestions or anything else there is the&nbsp;<a style="font-size:14px;color:#008000" href="https://github.com/Serilum/.issue-tracker" rel="nofollow">Github repo</a>. Thanks!</span><span style="font-size:6px"><br><br></span></p>
<p style="text-align:center"><a href="https://serilum.com/donate" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/projects/support.svg" alt="" width="306" height="50"></a></p>