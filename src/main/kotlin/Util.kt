val Times.shortPlaceholder: String
    get() {
        return when (this) {
            Times.YEARS -> "yr"
            Times.MONTHS -> "mo"
            Times.WEEKS -> "w"
            Times.DAYS -> "d"
            Times.HOURS -> "h"
            Times.MINUTES -> "m"
            Times.SECONDS -> "s"
        }
    }

fun Int.toTimeFormatted(): Map<Times, Int> {
    var remainder = this
    val years = remainder / 31536000
    remainder -= years * 31536000
    val months = remainder / 2592000
    remainder -= months * 2592000
    val weeks = remainder / 604800
    remainder -= weeks * 604800
    val days = remainder / 86400
    remainder -= days * 86400
    val hours = remainder / 3600
    remainder -= hours * 3600
    val minutes = remainder / 60
    remainder -= minutes * 60
    val seconds = remainder
    return mapOf(
        Times.YEARS to years,
        Times.MONTHS to months,
        Times.WEEKS to weeks,
        Times.DAYS to days,
        Times.HOURS to hours,
        Times.MINUTES to minutes,
        Times.SECONDS to seconds
    )
}

enum class Times(val placeholder: String) {

    YEARS("years"),
    MONTHS("months"),
    WEEKS("weeks"),
    DAYS("days"),
    HOURS("hours"),
    MINUTES("minutes"),
    SECONDS("seconds");

    override fun toString(): String {
        return placeholder
    }
}