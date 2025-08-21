# Crystal Optimizer (client-side)

**MC**: 1.21.5 | **Loader**: Fabric | **Java**: 21

### Build
1. Install JDK 21
2. `./gradlew build`
3. The mod jar is at `build/libs/crystal-optimizer-1.0.0.jar`

### Install
- Put the jar into your `.minecraft/mods` alongside **Fabric API 0.119.5+1.21.5**.

### Configure
- After first run, a config file appears at `.minecraft/config/crystaloptimizer.json`.
- Options:
  - `maxCrystalsRendered` (int)
  - `cullDistance` (double)
  - `disableBeam` (bool)

### Notes
- Client-side only. Doesn't affect damage or server logic.
