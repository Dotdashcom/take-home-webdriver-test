FROM markhobson/maven-chrome:jdk-11

ARG ALLURE_RELEASE="2.18.1"
ARG ALLURE_REPO=https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
      curl \
      unzip && \
    curl ${ALLURE_REPO}/${ALLURE_RELEASE}/allure-commandline-${ALLURE_RELEASE}.zip -L -o /tmp/allure-commandline.zip && \
        unzip -q /tmp/allure-commandline.zip -d / && \
        apt-get remove -y unzip && \
        rm -rf /tmp/* && \
        rm -rf /var/lib/apt/lists/* && \
        chmod -R +x /allure-$ALLURE_RELEASE/bin

RUN ln -s /allure-$ALLURE_RELEASE/bin/allure /usr/bin/allure
