#Demo project for custom AuthenticationProvider instead of calling default DaoAuthenticationProvider

The AuthenticationProvider in Spring-Security takes care of the authentication logic.

The default implementation of the AuthenticationProvider delegates the responsibility of finding the user in the system to a UserDetailsService and PasswordEncoder for password validation.

But if we have a custom authentication requirement that is not fulfilled by Spring-Security framework then we can build own authentication logic by implementing the AuthenticationProvider interface.