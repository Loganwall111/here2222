# Sift Anomaly — Minecraft Java 26.2 (Fabric)

This repository contains a Fabric mod project based on the supplied Rift Portal geometry archive and video-derived effects. The original Bedrock geometry, texture atlas and animation/controller JSON are extracted from the existing rift.zip at build time; the Java model preserves the source cube UVs, dimensions and pivots.

## Build
Requires Java 25 and Gradle 9.7.1. In the repository root, run `gradle build`. The build imports the original geometry resources from rift.zip and the animated texture strips in mod_video_assets.zip. The installable JAR is written to build/libs/.

GitHub Actions runs the same build and publishes the compiled JAR as a workflow artifact.

## Install
Install Fabric Loader 0.19.5+ and Fabric API 0.161.0+26.2 for Minecraft Java 26.2. Copy sift-anomaly-1.0.0.jar into your .minecraft/mods folder and launch the Fabric 26.2 profile.

## In game
Find Sift Rift Portal in the Functional Blocks creative tab and place it. It is a large non-colliding rendered portal. It plays the charge, impact and emergence VFX on placement; right-click with an empty hand to replay the sequence.

## Source fidelity
No new or AI-generated visual assets are included. Video VFX frames are sampled from the supplied extracted sequences and resized to 64×64 while preserving alpha. Java reproduces the main spawn/idle motion based on the provided Bedrock animation timing; it does not interpret the Bedrock animation format directly at runtime.
