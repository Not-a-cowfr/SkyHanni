package at.hannibal2.skyhanni.config.features.garden.pests;

import at.hannibal2.skyhanni.features.garden.pests.PestWarning;
import at.hannibal2.skyhanni.utils.OSUtils;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorButton;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorSlider;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorText;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class PestWarningSoundSettings {

    @Expose
    @ConfigOption(name = "Notification Sound", desc = "The sound played for the notification.")
    @ConfigEditorText
    public String name = "random.orb";

    @Expose
    @ConfigOption(
        name = "Repeat Sound Notification",
        desc = "Repeat the sound notification until wardrobe is opened or pests spawn" +
            "§eRecommended §lonly §rif you're pest farming!"
    )
    @ConfigEditorBoolean
    public boolean repeatSound = false;

    @Expose
    @ConfigOption(
        name = "Repeat Duration",
        desc = "Change how often the sound should be repeated in ticks. Change to 20 for only once per second."
    )
    @ConfigEditorSlider(minValue = 1, maxValue = 20, minStep = 1)
    public int repeatDuration = 20;

    @Expose
    @ConfigOption(name = "Pitch", desc = "The pitch of the notification sound.")
    @ConfigEditorSlider(minValue = 0.5f, maxValue = 2.0f, minStep = 0.1f)
    public float pitch = 0.5f;

    @ConfigOption(name = "Test Sound", desc = "Test current sound settings.")
    @ConfigEditorButton(buttonText = "Test")
    public Runnable testSound = PestWarning::playUserSound;

    @ConfigOption(name = "List of Sounds", desc = "A list of available sounds.")
    @ConfigEditorButton(buttonText = "Open")
    public Runnable listOfSounds = () -> OSUtils.openBrowser("https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/mapping-and-modding-tutorials/2213619-1-8-all-playsound-sound-arguments");
}