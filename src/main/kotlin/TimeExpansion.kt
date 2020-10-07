import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeExpansion : PlaceholderExpansion() {


    override fun getIdentifier(): String {
        return "time"
    }

    override fun getAuthor(): String {
        return "Jaimss"
    }

    override fun getVersion(): String {
        return "1.0.0"
    }

    override fun onRequest(player: OfflinePlayer?, identifier: String): String {


        if (identifier.startsWith("time_custom_format")) {
            return try {
                val format =
                    DateTimeFormatter.ofPattern(identifier.split("time_custom_format_").getOrNull(1) ?: "HH:mm")
                LocalDateTime.now().format(format)
            } catch (e: IllegalArgumentException) {
                "invalid pattern"
            }

        }

        if (identifier.startsWith("format_seconds")) {
            val time = identifier.split("format_seconds_")[1].toIntOrNull() ?: return "invalid time"
            val formatted = time.toTimeFormatted().filter { (_, time) -> time != 0 }
            var formattedTimeString = ""
            formatted.forEach { (unit, time) ->
                formattedTimeString += "$time${unit.shortPlaceholder} "
            }
            return formattedTimeString
        }

        return when (identifier) {
            "seconds", "second", "sec" -> DateTimeFormatter.ofPattern("ss").format(LocalDateTime.now())
            "minutes", "minute", "min" -> DateTimeFormatter.ofPattern("mm").format(LocalDateTime.now())
            "hours", "hour", "hr" -> DateTimeFormatter.ofPattern("HH").format(LocalDateTime.now())
            "hours12", "hour12", "hr12" -> DateTimeFormatter.ofPattern("hh").format(LocalDateTime.now())
            "am_pm" -> DateTimeFormatter.ofPattern("a").format(LocalDateTime.now())
            "day" -> DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now())
            "months", "month" -> DateTimeFormatter.ofPattern("MM").format(LocalDateTime.now())
            "year_long" -> DateTimeFormatter.ofPattern("yyyy").format(LocalDateTime.now())
            "year_short" -> DateTimeFormatter.ofPattern("yy").format(LocalDateTime.now())
            else -> "null"
        }

    }

}