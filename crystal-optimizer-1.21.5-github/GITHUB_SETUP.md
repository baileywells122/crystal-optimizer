# GitHub Setup for Crystal Optimizer

1. Create a new repository on GitHub (public or private).
2. Upload all these files (you can drag + drop the whole folder).
3. Commit and push.

## What happens

- Every push to `main` will:
  - Build the mod `.jar` with Gradle
  - Upload it as an **artifact** in the Actions tab
  - Publish it automatically under **Releases**

## Where to get your mod

- Go to the **Releases** section of your repo → download the `.jar`
- Drop it into your `.minecraft/mods` folder
- Done 🎉
