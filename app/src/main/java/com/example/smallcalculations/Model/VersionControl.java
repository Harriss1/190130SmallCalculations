package com.example.smallcalculations.Model;
//package com.example.smallcalculations.BuildConfig;

import com.example.smallcalculations.BuildConfig;


public class VersionControl {

    //edit manually:
    private final int major = 1;
    private final int minor = 0;
    private final int patch = 0;
    private final boolean isSnapshot = false;
    private final String comment = "firstVersioningTry";
    private final boolean useComment = false;

    //inserted automatically
    BuildConfig buildConfig = new BuildConfig();
    private final int formattedDate = buildConfig.formattedDate;
    private final int formattedTime = buildConfig.formattedTime;


    public VersionControl() {

    }

    public int getVersionCode() {
        return 10000;
        //its recommended to include the API and the target resolution type, I don't do that because
        //I want to learn basic versioning that is generally applied to all languages.
        //Just getting doubts, because every language and API maybe needs individual versioning...
    }

    public String getVersionString() {
        String suffix = "";
        if (isSnapshot) suffix = "pre-";
        String comment = "";
        if (useComment) comment="-"+this.comment;
        String version =
                Integer.toString(major) + "." +
                Integer.toString(minor) + "." +
                Integer.toString(patch) + "-" +
                suffix +
                Integer.toString(formattedDate) + "." +
                Integer.toString(formattedTime) +
                comment;



        //return "1.0.0-snap-20190304.2038-withSpice";

        return version;
    }
}

/*
major: API change
minor: visible change, backwards compatible to given API
patch: inside changes, not visible

suffix: pre-release, debug, snapshot, development, release, release-candidate

I want to include date and time. Additionally a little comment string, less than 10 characters.

The API needs to be documented for this system to work.

Additionally github makes a versioning system less important for beginners.

Actually Gradle seems to be best for this purpose.

Still, I should use my own system, and learn to store that little incrementing number myself...


gradle script:
android {
    defaultConfig {
        buildConfigField "long", "TIMESTAMP", System.currentTimeMillis() + "L"
    }
}
 */
