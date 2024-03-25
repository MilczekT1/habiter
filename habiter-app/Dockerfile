FROM konradboniecki/budget:java-base-image-latest
ARG ARTIFACT=habiter-*.jar
ADD /target/$ARTIFACT app.jar
ENTRYPOINT ["java", "-jar", \
    "-Djava.security.egd=file:/dev/./urandom ", "app.jar" \
]
