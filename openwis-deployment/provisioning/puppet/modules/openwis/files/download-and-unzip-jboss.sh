#!/bin/bash
#

wget http://repository-openwis-association.forge.cloudbees.com/artifacts/3.14.5/jboss-as-7.1.1.Final.tar.gz -O /tmp/jboss-as-7.1.1.Final.tar.gz
wget http://repository-openwis-association.forge.cloudbees.com/openwis/3.14.6/openwis-dataservice-config-files.zip -O /tmp/openwis-dataservice-config-files.zip

cd /home/openwis
tar -xvzf /tmp/jboss-as-7.1.1.Final.tar.gz
chown -R openwis: /home/openwis/jboss-as-7.1.1.Final

unzip -d /tmp /tmp/openwis-dataservice-config-files.zip