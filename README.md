# springEmptyBodyAdvice
Spring ResponseBodyAdvice is not call with an empty body

According with these issues:
* https://jira.spring.io/browse/SPR-12152
* https://jira.spring.io/browse/SPR-12778

with the resolution in this commit:
* https://github.com/spring-projects/spring-framework/commit/a9b2a12491aa2259851b93824b7e560b3dbd1902

even if the body is empty the ResponseBodyAdvice should be call.

In this method, there is a previous check that force to not call the advice:
ServletInvocableHandlerMethod.invokeAndHandle

To Check:
RequestResponseBodyAdviceChain

This code is to test that when the body is null the advice is not called.
