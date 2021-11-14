#Demo project for authorizing API's

When the Client makes a request with the credentials, the authentication filter will intercept the request and validate if the person is valid and is
he/she the same person whom they are claiming Post authentication the filter stores the UserDetails in the SecurityContext.

The UserDetails will have his user-name, authorities etc Now the authorization filter will intercept and decide whether the person has access to the given path based on this authorities stored in the SecurityContext.

If authorized the request will be forwarded to the applicable controllers.