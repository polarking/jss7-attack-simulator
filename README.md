# SS7 Attack Simulator based on RestComm's jss7.

## Introduction

This project is currenlty not maintained and may not build, I've made available the latest build [here](https://drive.google.com/file/d/0B5wpGwi_jRR5a1pUZ2laWnA0WmM/view?usp=drivesdk&resourcekey=0-p-bygW5WPF79Lc5tniAyGA).

Open Source Java SS7 attack simulator that makes it possible to simulate some publicly disclosed attacks on the SS7 network.

This project is part of an ongoing Master Thesis at NTNU Gjøvik, Norway.

The simulator supports two modes:

* Simple mode: Used to demonstrate some SS7 attacks.
* Complex mode: Includes a full network simulation containing 3 operators, where one of the subscribers is the victim of attacks by an adversary with access to the SS7 network.
  In this mode several nodes communicate using 13 standard procedures per the 3GPP MAP standard. After a mercy period, there will be launched attacks against the subscriber with the goal of obtaining the subscribers location and intercept SMS originally sent to this subscriber.

Traffic is generated using the SCTP protocol and all data is sent on the lo interface.

## License

SS7 Attack Simulator is licensed under the Free Open Source [GNU Affero GPL v3.0](http://www.gnu.org/licenses/agpl-3.0.html).

## Downloads

The latest build can be downloaded from [here](https://drive.google.com/file/d/0B5wpGwi_jRR5a1pUZ2laWnA0WmM/view?usp=sharing).

## Instructions

How to run the simulator:

* The simulator needs a working Java environment.
* Make sure you have SCTP support installed on Linux:
  * Fedora: lksctp-tools and kernel-modules-extra.
  * Ubuntu: libsctp1 and lksctp-tools.
* Download latest build [here](https://drive.google.com/file/d/0B5wpGwi_jRR5a1pUZ2laWnA0WmM/view?usp=sharing).
* Unzip the file.
* The simulator is launched with the script:

```
RELEASE_FOLDER/ss7/restcomm-ss7-simulator/bin/run.sh
```

* Run

``` 
run.sh help 
```

or

```
run.sh attack_simulator help 
```

for help on how to run the simulator.

The currently supported simple attacks are:

* location:ati
* location:psi
* intercept:sms

## Build From Source

Building from source can be done by using the instructions for jSS7, which can
be found [here](https://github.com/RestComm/jss7/wiki/Build-jSS7-from-Source).
