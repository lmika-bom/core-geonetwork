# OpenWIS / GeoNetwork Deployment

> **Note:** This sub-component is currently in the early stages of development, so there will be ongoing changes for the forseeable future.

> This readme file will be updated as the component evolves.

This sub-component provides facilites that are intended to be used for the provisioning & deployment of OpenWIS 4.x moving forward.

There are 3 aspects to this component:

1. [Puppet](https://docs.puppet.com/puppet/) scripts that are designed for provioning OpenWIS into any environment.
2. [Vagrant](https://www.vagrantup.com/docs/getting-started/) scripts that are designed to stand-up development [VirtualBox](https://www.virtualbox.org/) VMs using Puppet to provison them.
3. Shell scripts that are designed to deploy & configure the various OpenWIS components.

# Vagrant for Development VMs

## Getting Started

### Add the OpenWIS Vagrant Base Box

A bare-bones CentOS 7 has been created with the following included:

* CentOS 7 base install (up to date at 24/06/2016)
* Puppet installed - v3.8.7
* The following Puppet modules installed:
  * puppetlabs-stdlib - v4.12.0
  * AlexCline-dirtree - v0.2.1

This box should be downloaded & added to Vagrant by running:
```
vagrant box add --force openwis/centos7-xx https://repository-openwis-association.forge.cloudbees.com/artifacts/vagrant/openwis-centos-7.box
```

## Standing Up a Vagrant Environment

Ensure that you have followed the _Getting Started_ steps above, then from in the approritate Vagrant environment sub-folder run `vagrant up`.

For example to run-up an _all-in-one_ environment do:
```
cd vagrant-allinone
vagrant up
```

## Tearing Down a Vagrant Environment

One of the beauties of Vagrant is that it is very easy to tear-down your environment, should it get into a 'broken' state, and start again.  The `vagrant destroy -f` command will completely tear-down a broken environment. You then simply need to do `vagrant up` to start again.

For example to re-build the _all-in-one_ environment do:
```
cd vagrant-allinone
vagrant destroy -f
vagrant up
```

## Accessing the Deployed Applications

## Available Vagrant Environment Types

There is currently only one Vagrant configuration available that stands up an _all-in-one_ environment, where everything is deployed to a single server instance.  See below for the description of this environment.

There are plans to implement a _multi-server_ environment, where the OpenWIS components are deployed on different server instances, to be more representative of a full test/production environment.

### All-In-One Vagrant Environment

The _vagrant-allinone_ sub-folder, contains the Vagrant scripts that will stand-up a local development VM that contains all of the OpenWIS components depoyed into a single server.

This instance currently contains the following components:

* An empty PostgeSQL database
* The GeoNetwork/OpenWIS Portal deployed into the

# Puppet for Server Provisioning

# Shell Scripts for Component Deployment/Configuration
