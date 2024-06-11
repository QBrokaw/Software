#include <iostream>
#include <string>
#include <fmod.hpp>

int main() {
    FMOD::System* system;
    FMOD::Sound* sound;
    FMOD::Channel* channel;

    // Initialize FMOD system
    FMOD::System_Create(&system);
    system->init(32, FMOD_INIT_NORMAL, nullptr);

    while (true) {
        std::string filePath;
        std::cout << "Enter the MP3 file name (or 'q' to quit): ";
        std::cin >> filePath;

        if (filePath == "q") {
            break; // Exit the loop if the user enters 'q'
        }

        // Load the MP3 file
        system->createSound(filePath.c_str(), FMOD_DEFAULT, nullptr, &sound);

        // Play the audio
        system->playSound(sound, nullptr, false, &channel);

        // Wait until the audio finishes playing
        bool isPlaying = true;
        while (isPlaying) {
            channel->isPlaying(&isPlaying);
        }

        // Clean up
        sound->release();
    }

    // Clean up FMOD system
    system->close();
    system->release();

    return 0;
}
