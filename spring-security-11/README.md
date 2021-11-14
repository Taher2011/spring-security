#Demo project for enabling CORS and CSRF

1.CORS is a protocol that enables scripts running on a browser client to interact with resources from a different origin.

2.For example, if a UI app wishes to make an API call running on a different domain, it would be blocked from doing
so by default due to CORS So CORS is not a security issue/attack but the default protection provided by browsers to
stop sharing the data/communication between different origins.

3."other origins" means the URL being accessed differs from the location that the JavaScript is running from, by
having :-
a different scheme (HTTP or HTTPS)
a different domain
a different port