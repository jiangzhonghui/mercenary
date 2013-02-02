Zebia for Android
=================

Install android sdk
-------
- Download Android SDK Tools (see USE AN EXISTING IDE): http://developer.android.com/sdk/index.html
- Add a Platform 4.1.2 : http://developer.android.com/sdk/installing/adding-packages.html

Install project
-------
**Intellij** : Import project -> Create project from existing sources -> mercenary/android/  -> next -> when asking to select sdk : Android 4.1.2 (point to downloaded android sdk) -> next

Run project
-------
- Clic Menu -> Preferences -> (IP : 10.0.2.2 (if emulator) or real IP; Mount point : [empty])
- Clic search
- Pagination -> go to last song and "pull from down"


Functionnality Google Maps Api
-------------------------------
-------------------------------
[ 1) Optionnal) Install Google Play Service Sdk via le SDK manager ]
  1 bis) Add Google-Play-Services_Lib as dependency to project :
With IntelliJ : add a module dependency for sources AND add the   jar as librairy dependency.

 2) Run it... But : the functionnality Google Play Services is not includes in emulator ....
If you do'nt have a real device for that, there is a solution : launch an emulator and install 2 .apk :
- See http://nemanjakovacevic.net/blog/2012/12/how-to-make-android-google-maps-v2-work-in-android-emulator/ for explanations
- Get the apk, see danbrough answer http://stackoverflow.com/questions/13691943/this-app-wont-run-unless-you-update-google-play-services-via-bazaar/13869332#13869332
