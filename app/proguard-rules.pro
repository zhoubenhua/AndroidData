# app
-keep class * extends android.app.Fragment
-keep class * extends android.support.v4.app.Fragment
-keep class * extends android.view.View
-keep class * extends android.support.v7.widget.RecyclerView$Adapter{*;}

# sdk
-keep class com.chinapex.android.datacollect.**{*;}
-keep class com.chinapex.android.monitor.**{*;}

# WCDB
-keepclasseswithmembers,includedescriptorclasses class com.tencent.wcdb.** {
    native <methods>;
}
-keep,includedescriptorclasses class com.tencent.wcdb.database.SQLiteCustomFunction { *; }
-keep interface com.tencent.wcdb.support.Log$* { *; }
-keep class com.tencent.wcdb.** {*;}

# bean
-keep class com.chinapex.analytics.sample.bean.**{*;}

# okhttp
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn org.codehaus.mojo.animal_sniffer.*
-dontwarn okhttp3.internal.platform.ConscryptPlatform

# Gson
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Glide
-keep public class * implements  com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
-keep class com.bumptech.** {*;}
