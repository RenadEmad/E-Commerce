object AppValidators {

    private val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
    private val PHONE_REGEX = "^01[0125][0-9]{8}$".toRegex() // أرقام مصر

    fun validateName(name: String): String? {
        return when {
            name.trim().isEmpty() -> "Please enter Name."
            name.trim().length < 3 -> "Name must be at least 3 characters."
            else -> null
        }
    }

    fun validateEmail(email: String): String? {
        val value = email.trim()
        return when {
            value.isEmpty() -> "Please enter Email."
            !value.matches(EMAIL_REGEX) -> "Please enter valid Email."
            else -> null
        }
    }

    fun validatePhone(phone: String): String? {
        val value = phone.trim()
        return when {
            value.isEmpty() -> "Please enter Phone number."
            !value.matches(PHONE_REGEX) -> "Please enter valid Phone number."
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Please enter Password."
            password.length < 8 -> "Password must be at least 8 characters."
            !password.any { it.isDigit() } -> "Password must contain a number."
            !password.any { it.isLetter() } -> "Password must contain a letter."
            else -> null
        }
    }

    fun validateRePassword(password: String, rePassword: String): String? {
        return when {
            rePassword.isEmpty() -> "Please confirm Password."
            rePassword != password -> "Passwords do not match."
            else -> null
        }
    }
}