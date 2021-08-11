## Android Tech Assignment

> This project was setup on Android Studio Arctic Fox v2020.3.1 and uses Gradle Build Tools v7.0.0 and Kotlin v1.5.21

A client has a requirement to display a list of objects on a mobile application. The objects are unique per user and will have a different set of data set.

The API provides 3 separate endpoints that gives the following information:

1. `SampleApi.getCollectionInfo()` - which tells us what fields are to be displayed.
2. `SampleApi.getCollectionMeta()` - which tells us meta data on all of the fields available.
3. `SampleApi.getCollectionObjects()` - which provides us the list of objects from the database.

You have been tasked with retrieving the objects, and mapping these into a UI Model that can be displayed, ensuring to only display
the fields which are defined in the CollectionInfo.

You will be required to use the `fields` param defined in the `CollectionMetaApiModel` to retrieve the meta data on each of the fields. This will tell you information such as its data type.

Use this meta data, to generate a list of Fields for each Object returned in the `SampleApi.getCollectionObjects()` call.

### What we are reviewing in your assignment:

1. How you make use of threading to chain these calls
2. How you choose to model your data
3. How you consider performance when mapping these data sets

You will not be expected to render this data on the UI however you are expected to build out a UI model in the presentation layer. You should however, print a log statement of the objects list fields, with a dash line divider between each object, in the following way:

```
{{field alias}}: {{field value}}
{{field alias}}: {{field value}}
.....
==================
```


### Instructions
1. Clone the repository and make it private
2. Add users `IndianaSloan` and `mevansjr` to collaborate on the project.
3. Make commits as you feel necessary. Please ensure to make your commits clear and concise with details in your commit message.
4. Once you are readym open a PR on your work and assign both `IndianaSloan` and `mevansjr` to review your PR.
5. Once completed, email your 3Advance contact and advise you have this completed.
